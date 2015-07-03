package com.qq.weixin.api.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class CSVExport {

    public static void export(File file, String data, boolean isBOM) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "utf-8"));
            if (isBOM) {
                // BOM UTF-8
                writer.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,
                        (byte) 0xBF }));
                writer.flush();
            }
            writer.write(data);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void export(File file, String data) {
        export(file, data, true);
    }


    public static void export(File file, List<?> data, boolean isBOM){

        if(data !=null){
            try {
                Method method = data.getClass().getMethod("get",java.lang.Integer.class);
                Class returnTypeClass = method.getReturnType();
                System.out.println(returnTypeClass.getCanonicalName());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }
}
