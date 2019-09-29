package com.khisoft.magiworld;


import com.khisoft.magiworld.exception.CharacterException;
import com.khisoft.magiworld.model.ICharacter;

import java.util.List;
import java.util.Scanner;

public class MagiWorld {


    private static final Scanner scanner = new Scanner(System.in);
    /**
     * Launch the program
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try {
            final List<ICharacter> characters = MagiWorldUtils.createCharacters(scanner);
        } catch (CharacterException e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }

        /*boolean stop = false;
        while(!stop)
        {

            if(stop)
            {
                break;
            }
        }*/

    }


}
