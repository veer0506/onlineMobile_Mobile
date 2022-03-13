package com.cg.oma.demo.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GloballyResources {
 public static Logger getLogger(Class className) {
	 return LoggerFactory.getLogger(className);
 }
}
