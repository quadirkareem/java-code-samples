package com.quadirkareem.dsa;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

	@Test
	public void filter_whenNameNotEmpty_thenName(){
		String s = null;
	    Optional<String> petNameOpt = Optional.ofNullable(s);
	    String petName = petNameOpt.filter(name -> !name.trim().isEmpty())
	    

	       .orElseThrow(IllegalArgumentException::new);
//	    String petName = petNameOpt.orElse("chalo");
	    assertEquals("Bobby", petName);
	}
}
