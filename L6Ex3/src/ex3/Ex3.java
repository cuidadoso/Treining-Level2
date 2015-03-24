package ex3;

import java.util.List;
import net.yandex.speller.services.spellservice.*;

public class Ex3 {

    public static void main2(String[] args) {
        SpellService factory=new SpellService();
        SpellServiceSoap proxy=factory.getSpellServiceSoap();
        
        CheckTextRequest   in = new CheckTextRequest();
        CheckTextResponse out =null;
        
        in.setText("I wike to svin.");
        out = proxy.checkText(in);
        
        SpellResult sr=out.getSpellResult();
        
        List<SpellError> erList=sr.getError();
        
        for(SpellError er : erList){
            System.out.print(er.getWord()+" - ");
            List<String> words=er.getS();
            for(String s : words)
               System.out.print(s+" , ");
            System.out.println();
        }
    }
}
