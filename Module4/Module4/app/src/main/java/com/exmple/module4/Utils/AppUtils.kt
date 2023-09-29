package com.exmple.module4.Utils

import android.util.Patterns
import java.util.regex.Pattern

class AppUtils {
     companion object{
        private const val PASSWORD_PATTERN =
             "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
         private const val PERSON_PATTERN=  "^[a-zA-Z]+$"

         fun  isvalidemail(email: String):Boolean{
             return Patterns.EMAIL_ADDRESS.matcher(email).matches()

         }
         fun isvalidpass(password:String):Boolean{
             return Pattern.matches(PASSWORD_PATTERN,password)
         }
         fun isvalidcontact(contact:String):Boolean{
            return contact.length == 10
         }
         fun isvalidname(name:String):Boolean{
             return Pattern.matches(PERSON_PATTERN,name)
         }




     }
}