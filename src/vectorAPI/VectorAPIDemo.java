package vectorAPI;


import jdk.incubator.vector.IntVector;
import  jdk.incubator.vector.VectorSpecies;



public class VectorAPIDemo {

    public static void main() {
        int[] arrayOne = new int[16];
        int[] arrayTwo = new int[16];


        for ( int i = 0, j = 16 ;  i < 16;  i++, j-- ) {
            arrayOne[i] = i ;
            arrayTwo[i] = j;
        }

        int[] result = new int[arrayOne.length];

        //Preferred species based on CPU architecture, in this case 16
        VectorSpecies<Integer> species = IntVector.SPECIES_PREFERRED;

        for (int i = 0; i < arrayOne.length; i += species.length()) {
            IntVector vectorOne = IntVector.fromArray(species, arrayOne, i);
            IntVector vectorTwo = IntVector.fromArray(species, arrayTwo, i);

            IntVector resultMult = vectorOne.mul(vectorTwo);
            IntVector resultVector = vectorOne.add(vectorTwo);
            IntVector resultSub = vectorOne.sub(vectorTwo);
            IntVector resultDiv = vectorOne.div(vectorTwo);
            resultVector.intoArray(result, i);
            System.out.println(STR."result of multiply:\{resultMult}");
            System.out.println(STR."result of substraction:\{resultSub}");
            System.out.println(STR."result of division:\{resultDiv}");
        }


        for (int i = 0; i < result.length; i++) {
            System.out.println(STR."Result[\{i}] = \{result[i]}");
        }
    }
}
