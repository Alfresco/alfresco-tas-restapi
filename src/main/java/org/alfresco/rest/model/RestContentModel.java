package org.alfresco.rest.model;

import org.alfresco.utility.model.TestModel;

/**
 * Created by Claudia Agache on 11/11/2016.
 */
public class RestContentModel extends TestModel
{
    private int sizeInBytes;
    private String mimeTypeName;
    private String mimeType;
    private String encoding;

    public int getSizeInBytes()
    {
        return sizeInBytes;
    }

    public void setSizeInBytes(int sizeInBytes)
    {
        this.sizeInBytes = sizeInBytes;
    }

    public String getMimeTypeName()
    {
        return mimeTypeName;
    }

    public void setMimeTypeName(String mimeTypeName)
    {
        this.mimeTypeName = mimeTypeName;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }
}
