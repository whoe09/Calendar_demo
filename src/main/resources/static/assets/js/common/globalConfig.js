// datepicker Setting

let dateRangePicker = {
    customTodayInit: function (id) {
        let $element = $(`#${id}`);
        let today = moment();

        $element.daterangepicker({
            "showDropdowns": true,
            "showWeekNumbers": false,
            "showISOWeekNumbers": false,
            "timePicker": false,
            autoUpdateInput: false,
            locale: {
                format: "YYYY-MM-DD",
                daysOfWeek: ["일", "월", "화", "수", "목", "금", "토"],
                monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
                applyLabel: "선택",
                cancelLabel: "초기화"
            },
            "alwaysShowCalendars": true,
            "applyButtonClasses": "btn-default shadow-0",
            "cancelClass": "btn-success shadow-0",
            "startDate":today,
            "endDate":today
        });
        $element.val(today.format('YYYY-MM-DD') + ' - ' + today.format('YYYY-MM-DD'))
        $element.on('apply.daterangepicker', function(ev, picker) {
            $(this).val(picker.startDate.format('YYYY-MM-DD') + ' - ' + picker.endDate.format('YYYY-MM-DD'));
        });
    }
}

function ajax(url, type, param, onSuccess, onError = function (request, status, error) {
    ajaxErrorType(request, status);
}) {
    return $.ajax({
        type: type,
        url: url,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(param),
        cache: "false",
        success: onSuccess,
        error: onError
    });
}

function ajaxErrorType(request, status) {
    if (status === 403) {
        swal.fire({
            icon: `info`,
            title: `세션 만료`,
            text: `다시 로그인해 주세요.`
        }).then((result) => {
            if (result.value) {
                location.replace("/login");
            }
        });
    } else if (request.responseJSON.error.code === "D100") {
        swal.fire({
            icon: `error`,
            title: `중복된 데이터를 입력하였습니다`,
            text: `중복데이터는 입력할 수 없습니다.`
        });
    } else {
        swal.fire({
            icon: `error`,
            title: `서버와의 통신에 실패하였습니다.`,
            text: `관리자에게 문의 바랍니다.`
        });
    }
}