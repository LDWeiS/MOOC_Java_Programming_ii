
public class Checker {

    public Checker() {
    }

    public boolean isDayOfWeek(String string) {
        return string.toLowerCase().matches("mon|tue|wed|thu|fri|sat|sun");
    }

    public boolean allVowels(String string) {
        return string.toLowerCase().matches("^[aeiou]*");
    }
    
    public boolean timeOfDay(String string) {
        return string.toLowerCase().matches("^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");
    }

}
