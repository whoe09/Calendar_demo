package com.full.calendar.open_calendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
class OpenCalendarApplicationTests {

	private int KEY = 123;
	private String FILE_PATH="D:\\Cho\\test.jpg";

	@Test
	void contextLoads() {
		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);

			byte data[] = new byte[fis.available()];

			fis.read(data);
			int i = 0;

			for(byte b : data) {
				data[i] = (byte)(b^KEY);
				i++;
			}

			//OPEN a file
			FileOutputStream fos = new FileOutputStream(FILE_PATH);

			//Wring new byte
			fos.write(data);

			//closing
			fos.close();
			fis.close();
			System.out.println("Encryption Done...");
		} catch (IOException e) {

		}
	}

	@Test
	void decrypt() {
		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);

			byte data[] = new byte[fis.available()];

			fis.read(data);

			int i = 0;

			for(byte b : data) {
				data[i] = (byte) (b^KEY);
				i++;
			}

			// Opening file
			FileOutputStream fos = new FileOutputStream(FILE_PATH);

			fos.write(data);
			fos.close();
			fis.close();
			System.out.println("Decryption Done...");
		} catch (IOException e) {

		}
	}

}
