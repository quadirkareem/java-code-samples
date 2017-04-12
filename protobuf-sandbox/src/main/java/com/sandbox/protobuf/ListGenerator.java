package com.sandbox.protobuf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sandbox.protobuf.protobuf.types.EntryProtos;
import com.sandbox.protobuf.protostuff.types.Entry;
import com.sandbox.protobuf.protostuff.types.EntryList;

public class ListGenerator {
	
	public static final String filename = "src/main/resources/input.txt";
	private static List<String> words;
	private static Scanner scanner;
	
	static {
		try {
			scanner = new Scanner(new File(filename));
			words = new ArrayList<String>();
			while(scanner.hasNext()) {
				words.add(scanner.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<SerialEntry> generateSerialEntries(int size) {
		List<SerialEntry> list = new ArrayList<SerialEntry>();
		int count = 0;
		for(String w : words) {
			list.add(new SerialEntry(String.valueOf(count), w));
			count++;
		}
		
		return list;
	}

	public static List<ExternEntry> generateExternEntries(int size) {
		List<ExternEntry> list = new ArrayList<ExternEntry>();
		int count = 0;
		for(String w : words) {
			list.add(new ExternEntry(String.valueOf(count), w));
			count++;
		}
		
		return list;
	}

	public static EntryList generateProtostuffEntriesV2(int size) {
		List<Entry> list = new ArrayList<Entry>();
		int count = 0;
		for(String w : words) {
			list.add(new Entry(String.valueOf(count), w));
			count++;
		}
		
		EntryList ls = new EntryList();
		ls.setEntryList(list);
		
		return ls;
	}
	
	public static List<Entry> generateProtostuffEntries(int size) {
		List<Entry> list = new ArrayList<Entry>();
		int count = 0;
		for(String w : words) {
			list.add(new Entry(String.valueOf(count), w));
			count++;
		}
		
		return list;
	}
	

	public static EntryProtos.EntryList generateProtobufEntries(int size) {
		EntryProtos.EntryList.Builder listBuilder = EntryProtos.EntryList.newBuilder();
		int count = 0;
		for(String w : words) {
			listBuilder.addEntry(EntryProtos.Entry.newBuilder().setKey(String.valueOf(count)).setValue(w).build());
			count++;
		}
		
		return listBuilder.build();
	}
}
