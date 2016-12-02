package org.literacyapp.dao.converter;

import android.util.Log;

import org.greenrobot.greendao.converter.PropertyConverter;
import org.literacyapp.model.enums.content.allophone.VowelLength;

public class VowelLengthConverter implements PropertyConverter<VowelLength, String> {

    @Override
    public VowelLength convertToEntityProperty(String databaseValue) {
        Log.d(getClass().getName(), "convertToEntityProperty");

        VowelLength entityProperty = VowelLength.valueOf(databaseValue);
        Log.d(getClass().getName(), "entityProperty: " + entityProperty);
        return entityProperty;
    }

    @Override
    public String convertToDatabaseValue(VowelLength entityProperty) {
        Log.d(getClass().getName(), "convertToDatabaseValue");

        String databaseValue = entityProperty.toString();
        Log.d(getClass().getName(), "databaseValue: " + databaseValue);
        return databaseValue;
    }
}
