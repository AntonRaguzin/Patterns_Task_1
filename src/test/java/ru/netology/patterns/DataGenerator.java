package ru.netology.patterns;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;



public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String city = Faker.instance(Locale.forLanguageTag(locale)).address().city();
        return city;
    }


    public static String generateName(String locale) {
        String lastName = Faker.instance(Locale.forLanguageTag(locale)).name().lastName();
        String firstName = Faker.instance(Locale.forLanguageTag(locale)).name().firstName();
        String name = lastName + " " + firstName;
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = Faker.instance(Locale.forLanguageTag(locale)).phoneNumber().phoneNumber();
        return phone;
    }
}
//    public static class Registration {
//    private Registration(){
//    }
//    }



//        public static UserInfo generateUser(String locale) {
//
//            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
//            // generateName(locale), generatePhone(locale)
//            return user;
//        }
//    }

//    @Value
//    public static class UserInfo {
//        String city;
//        String name;
//        String phone;
//    }



