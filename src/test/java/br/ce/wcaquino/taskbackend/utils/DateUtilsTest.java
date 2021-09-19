package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
//	datas futuras
	@Test
	public void retornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030,01,01);
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
	}
//	datas passadas
	@Test
	public void retornarTrueParaDatasPassadas() {
		LocalDate date = LocalDate.of(2020,01,01);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
	}
//	data presente
	@Test
	public void retornarTrueParaDataPresente() {
		LocalDate date = LocalDate.now();
		
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
	}
}
