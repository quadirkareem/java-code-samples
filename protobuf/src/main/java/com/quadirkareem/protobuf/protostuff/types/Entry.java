// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from resources

package com.quadirkareem.protobuf.protostuff.types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import io.protostuff.GraphIOUtil;
import io.protostuff.Input;
import io.protostuff.Message;
import io.protostuff.Output;
import io.protostuff.Schema;
import io.protostuff.UninitializedMessageException;

public final class Entry implements Externalizable, Message<Entry>, Schema<Entry>
{

    public static Schema<Entry> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static Entry getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final Entry DEFAULT_INSTANCE = new Entry();

    
    private String key;
    private String value;

    public Entry()
    {
        
    }

    public Entry(
        String key,
        String value
    )
    {
        this.key = key;
        this.value = value;
    }

    // getters and setters

    // key

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    // value

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
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

    public Schema<Entry> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public Entry newMessage()
    {
        return new Entry();
    }

    public Class<Entry> typeClass()
    {
        return Entry.class;
    }

    public String messageName()
    {
        return Entry.class.getSimpleName();
    }

    public String messageFullName()
    {
        return Entry.class.getName();
    }

    public boolean isInitialized(Entry message)
    {
        return 
            message.key != null 
            && message.value != null;
    }

    public void mergeFrom(Input input, Entry message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    message.key = input.readString();
                    break;
                case 2:
                    message.value = input.readString();
                    break;
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, Entry message) throws IOException
    {
        if(message.key == null)
            throw new UninitializedMessageException(message);
        output.writeString(1, message.key, false);

        if(message.value == null)
            throw new UninitializedMessageException(message);
        output.writeString(2, message.value, false);
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
