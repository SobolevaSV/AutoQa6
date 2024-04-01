package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // добавяем логику для объявления переменной date и задания её значения, для генерации строки с датой
        // используем класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        // добавляем логику для объявления переменной city и задания её значения,
        // генерацию выполняем, используя массив валидных городов и класс Random
        Random random = new Random();
        var cities = new String[]{"Уфа", "Йошкар-Ола", "Петрозаводск", "Саранск", "Казань", "Ижевск", "Пермь",
                "Владивосток", "Хабаровск", "Архангельск", "Новосибирск", "Екатеринбург", "Иркутск",
                "Киров", "Санкт-Петербург", "Тюмень", "Челябинск", "Ростов-на-Дону"};
        return cities[random.nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // добавляем логику для объявления переменной name и задания её значения,
        // для генерации используем Faker
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        // добавляем логику для объявления переменной phone и задания её значения,
        // для генерации используем Faker
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // добавяем логику для создания пользователя user с использованием
            // методов generateCity(locale), generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}