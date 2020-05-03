package com.ebiz.generator.provider.java.model;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

import com.ebiz.generator.util.StringHelper;


public class JavaMethod {
	private JavaClass clazz;

	private Method method;

	public JavaMethod(Method method, JavaClass clazz) {
		super();
		this.method = method;
		this.clazz = clazz;
	}

	public JavaClass getClazz() {
		return clazz;
	}

	public String getMethodName() {
		return method.getName();
	}

	public JavaClass getReturnType() {
		return new JavaClass(method.getReturnType());
	}

	@SuppressWarnings("rawtypes")
	public List<MethodParameter> getParameters() {
		Class[] parameters = method.getParameterTypes();
		List<MethodParameter> results = new ArrayList<MethodParameter>();
		for (int i = 0; i < parameters.length; i++) {
			results.add(new MethodParameter(i + 1, new JavaClass(parameters[i])));
		}
		return results;
	}

	public String getMethodNameUpper() {
		return StringHelper.capitalize(getMethodName());
	}

	public String toString() {
		return "JavaClass:" + clazz + " JavaMethod:" + getMethodName();
	}
}
