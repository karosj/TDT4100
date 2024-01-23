import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private String email;
    private char gender;
    private Date birthday;
    private List<String> CountryCode = Arrays.asList("ad", "ae", "af", "ag", "ai", "al",
            "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi",
            "bj",
            "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch",
            "ci",
            "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz",
            "ec",
            "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg",
            "gh",
            "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu",
            "id",
            "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km",
            "kn", "kp", "kr",
            "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me",
            "mf", "mg", "mh",
            "mk", "ml",
            "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf",
            "ng", "ni", "nl",
            "no", "np",
            "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py",
            "qa", "re", "ro",
            "rs", "ru", "rw", "sa",
            "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx",
            "sy", "sz",
            "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug",
            "um", "us", "uy",
            "uz", "va",
            "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!checkNameValid(name)) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !checkEmailValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (!((gender == 'M') || (gender == 'F') ||
                (gender == '\0'))) {
            throw new IllegalArgumentException("Invalid gender");
        }
        this.gender = gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        if (birthday.after(new Date())) {
            throw new IllegalArgumentException("Invalid birthday");
        }
        this.birthday = birthday;
    }

    private boolean checkNameValid(String name) {
        return name != null && name.matches("[A-Za-z]{2,} [A-Za-z]{2,}");
    }

    private boolean checkEmailValid(String email) {
        String[] emailParts = email.split("@");
        if (emailParts.length != 2) {
            return false;
        }

        String[] nameParts = this.name.toLowerCase().split(" ");
        String[] localParts = emailParts[0].toLowerCase().split("\\.");
        if (localParts.length != 2 ||
                !localParts[0].equals(nameParts[0]) ||
                !localParts[1].equals(nameParts[1])) {
            return false;
        }

        String domain = emailParts[1];
        String[] domainParts = domain.split("\\.");
        if (domainParts.length != 2) {
            return false;
        }

        String countryCode = domainParts[1];
        if (!CountryCode.contains(countryCode.toLowerCase())) {
            return false;
        }

        return true;
    }

}
