// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from resources

package com.quadirkareem.protobuf;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class ExternEntry implements Externalizable {

	private String key;
	private String value;

	public ExternEntry() {

	}

	public ExternEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}

	// getters and setters

	// key

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	// value

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(key);
		out.writeObject(value);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		key = (String) in.readObject();
		value = (String) in.readObject();
	}

}
