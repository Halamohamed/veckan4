package se.ecutbildning.data;

public class PersonSequencer {

    private static int personId;
    static void setPersonId(int id){
        PersonSequencer.personId = id;
    }
    static int lastPersonId(){
        return personId;
    }
    public static int nextPersonId(){
        return ++personId;
    }
    static void reset(){
        personId = 0;
    }
}
