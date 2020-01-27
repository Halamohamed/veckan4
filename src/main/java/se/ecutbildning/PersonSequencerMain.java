package se.ecutbildning;

import se.ecutbildning.data.PersonSequencer;
import se.ecutbildning.data.PropertyFileHandler;

public class PersonSequencerMain {
    public static void main(String[] args) {
        /*PersonSequencer.nextPersonId();
        PropertyFileHandler.updateProperties();
*/
        PropertyFileHandler.initIdProperties();
        System.out.println(PersonSequencer.nextPersonId());
        PropertyFileHandler.updateProperties();
    }
}
