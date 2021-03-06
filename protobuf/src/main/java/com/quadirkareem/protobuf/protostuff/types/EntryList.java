// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from resources

package com.quadirkareem.protobuf.protostuff.types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

import io.protostuff.GraphIOUtil;
import io.protostuff.Input;
import io.protostuff.Message;
import io.protostuff.Output;
import io.protostuff.Schema;

public final class EntryList implements Externalizable, Message<EntryList>, Schema<EntryList>
{

    public static Schema<EntryList> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static EntryList getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final EntryList DEFAULT_INSTANCE = new EntryList();

    
    private List<Entry> entry;

    public EntryList()
    {
        
    }

    // getters and setters

    // entry

    public List<Entry> getEntryList()
    {
        return entry;
    }

    public void setEntryList(List<Entry> entry)
    {
        this.entry = entry;
    }

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<EntryList> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public EntryList newMessage()
    {
        return new EntryList();
    }

    public Class<EntryList> typeClass()
    {
        return EntryList.class;
    }

    public String messageName()
    {
        return EntryList.class.getSimpleName();
    }

    public String messageFullName()
    {
        return EntryList.class.getName();
    }

    public boolean isInitialized(EntryList message)
    {
        return true;
    }

    public void mergeFrom(Input input, EntryList message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    if(message.entry == null)
                        message.entry = new ArrayList<Entry>();
                    message.entry.add(input.mergeObject(null, Entry.getSchema()));
                    break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, EntryList message) throws IOException
    {
        if(message.entry != null)
        {
            for(Entry entry : message.entry)
            {
                if(entry != null)
                    output.writeObject(1, entry, Entry.getSchema(), true);
            }
        }

    }

    public String getFieldName(int number)
    {
        return Integer.toString(number);
    }

    public int getFieldNumber(String name)
    {
        return Integer.parseInt(name);
    }
    
}
