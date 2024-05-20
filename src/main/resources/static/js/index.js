"use strict"

$(async function () {
    await listItem.init();
    calendarAction.init();
    calendarModal.init();
    $("#dailyLogAddBtn").on(`click`,function () {
        let emptyChk = validChk.emptyChk(document.getElementById("dailyLogInfoForm"));
        if(emptyChk !== undefined) {
            crudCalendarEvent.register(emptyChk);
        }
    });

});
let logStatus = [];
let renderedLogStatus = {};
let calendarAction= {
    init: function () {
        this.datepickerInit();
        let $calendarEl = document.getElementById("calendar");
        let calendar = new FullCalendar.Calendar($calendarEl, {
            customButtons: {
                addListButton: {
                    text: 'add',
                    click: function () {
                        calendarModal.addLogData();
                    }
                },
                customNext: {
                    text:'Next',
                    click: function () {
                        calendar.next();
                    }
                },
                customPrev: {
                    text:'Prev',
                    click: function () {
                        calendar.prev();
                    }
                },
            },
            header: {
                left: `addListButton,customPrev,customNext`,
                center:`title`,
                right: ``,
            },
            plugins: ['dayGrid'],
            locale: 'ko',
            businessHours: true,
            editable: true,
            selectable: true,
            contentHeight:"auto",
            eventOrder: "logStatus",
            events: function (fetchInfo, successCallback, failureCallback) {
                let startDay = fetchInfo.start;
                let count = 1;
                if(startDay.getDate()===1) {
                    count--;
                }
                startDay.setMonth(startDay.getMonth()+count);
                ajax(
                    `/daily?searchDate=${startDay.toISOString()}`,
                    `GET`,
                    undefined,
                    (success) => {
                        let events = success.data.map(function (event) {
                            return {
                                title: event.title,
                                start: event.startDate,
                                end: event.endDate,
                                logStatus: event.logStatus
                            };
                        });
                        successCallback(events);
                    },
                    (error) => {
                        failureCallback();
                    }
                )
            },
            eventRender: handleEventRender,
            datesRender: handleDatesRender,
            eventBackgroundColor: 'transparent'
        })
        calendar.render();
    },
    datepickerInit: function () {
        dateRangePicker.customTodayInit(`dailyRegDate`);
    }

}
let calendarModal = {
    init: function () {

    },

    userListSelect: function (success) {
        let loopUserData = success.data;
        let userContent = ``;
        for (let userData of loopUserData) {
            userContent += `<option value="${userData.id}">${userData.userName}</option>`
        }
        // document.getElementById("logContent").insertAdjacentHTML("beforeend", innerContent);
        let loopLog = ``;
        let count = 0;
        for (const logValue of logStatus) {
            loopLog += `<div>
                        <label class="form-label" for="${logValue.key}">${logValue.desc}</label>
                        <select class='dynamic-select' multiple="multiple" name="${logValue.key}">
                    ${userContent}
                    </select></div>`;
            count++;
        }
        document.getElementById("logContent").insertAdjacentHTML("beforeend", loopLog);

    },
    addLogData: function () {
        let $calendarModal = $("#dailyLogModal");
        ajax(
            '/user',
            'GET',
            undefined,
            (success) => {
                this.userListSelect(success);
                $(".dynamic-select").each(function () {
                    $(".dynamic-select").select2({
                        dropdownParent: $calendarModal,
                        placeholder: "Select State"
                    });
                })
            }
        )
        $calendarModal.modal('show');
    },

    hideModal: function (modalElement) {
        this.init();
        modalElement.modal('hide');
    }
}
let crudCalendarEvent = {
    register: function (data) {
        console.log(data);
        ajax(
            `/daily`,
            `POST`,
            data,
            (response) => {
            }
        )
    }
}
let validChk = {
    emptyChk: function (form) {
        const formData = new FormData(form);
        const data = {};
        formData.forEach((value,key) => {
            if(!data[key]) {
                data[key] = value;
            } else {
                if(!Array.isArray(data[key])) {
                    data[key] = [data[key]];
                } data[key].push(value);
            }
        });
        console.log()
        if(Object.keys(data).filter(key=>key !=="dailyRegDate").length<=0) {
            console.log("입력값 부족");
        } else {
            return data;
        }
    }
}
let listItem = {
    init: async function () {
        return await ajax(
            `/daily/log/status`,
            `GET`,
            undefined,
            (success) => {
                logStatus = success.data;


            }
        )
    }
}

function getDateValue() {
    let $dailyRegDate = $("#dailyRegDate").data('daterangepicker');
    return {
        "startDate" : $dailyRegDate.startDate,
        "endDate" : $dailyRegDate.endDate,
    }
}

function handleEventRender(info) {
    let event = info.event;
    let dateStr = event.start.toISOString().split('T')[0];

    if(!renderedLogStatus[dateStr]) {
        renderedLogStatus[dateStr] = new Set();
    }

    let logStatus = event.extendedProps.logStatus;
    if(renderedLogStatus[dateStr].has(logStatus)) {
        info.el.innerHTML = event.title;
    } else {
        renderedLogStatus[dateStr].add(logStatus);
        updateEventTitle(info.el,logStatus,event.title);
    }
}
function updateEventTitle(ele,logStatus,title) {
    let titleElement = document.createElement('div');
    titleElement.innerHTML = `${logStatus} - ${title}`;
    ele.innerHTML = '';
    ele.appendChild(titleElement);
}

function handleDatesRender() {
    renderedLogStatus = {};
}

