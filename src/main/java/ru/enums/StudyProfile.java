package ru.enums;

public enum StudyProfile {
    MEDICINE("Медицина"), JOURNALISM("Журналистика"), JURISPRUDENCE("Юриспруденция"), PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"), MATHEMATICS("Математика");

    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

}
