/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Convertidor {

    private static SimpleDateFormat _yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
    
    
     public static java.sql.Date convertidortoSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public static Date getDateFromYYYYMMDD(String dateAsString) {
        try {
            Date date = _yyyyMMdd.parse(dateAsString);
            return date;
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String getStringFromDate(Date date) {
        return _yyyyMMdd.format(date);
    }
    
   

}
