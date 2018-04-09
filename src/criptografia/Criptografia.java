package criptografia;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Criptografia {
    static Random rd = new Random();
    static char[] ch = {'1','2','3','4','5','6','7','8','9','0','A','B','C',
                'D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
                'R','S','T','U','V','X','W','Y','Z','Ç', ' ', '%', '#','&','*','a',
                'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',    
                't','u','v','x','w','y','z'};
    public static void criptografar(String inome){
        String cripnome ="";
         for (int i = 0; i < inome.length();i++ ){
            for (int j = 0; j < ch.length;j++){
                if (inome.charAt(i) == ch[j]) {
                  int chave = rd.nextInt(10)  ;
                  cripnome += ch[(j + chave)% ch.length];
                  cripnome += ch[chave] ;
                  break;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Seu codigo criptografado é : " + cripnome);
    }
    
   
    
    public static void descriptografar(String inome){
        String cripnome ="";
        int chave = -1, posletra = -1;
        for (int i = 0; i < inome.length();i++){
            if ( i %2 == 0){
                for (int j = 0; j <= ch.length; j++){
                  if (inome.charAt(i) == ch[j]){
                      posletra = j;
                      break;
                  }  
                }      
            } else{
               for (int j = 0; j<=ch.length; j++){
                  if (inome.charAt(i) == ch[j]){
                      chave = j;
                      break;
                  }  
               } 
            }
             if ((posletra >= 0) && (chave >= 0)) {
                 if ((posletra - chave) < 0){
                    posletra += ch.length;
                    cripnome += ch[posletra - chave];
                    posletra = -1;
                    chave = -1;
                 }else {
                    cripnome += ch[posletra - chave]; 
                    posletra = -1;
                    chave = -1; 
                 }
             }
          
        }
        JOptionPane.showMessageDialog(null, "Seu codigo descriptografado é : " + cripnome);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int resp;
        do{
            resp = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a operação que gostaria de executar: \n 1 - Criptografar " +
                                                                                                                 "\n 2 - Descriptografar" +
                                                                                                                 "\n 3 - Sair" ));
            
              if (resp == 1){
                 String nome = JOptionPane.showInputDialog(null,"Digite o texto que gostaria de criptografar: ");
                 criptografar(nome);             
              }
              if (resp == 2){
                 String nome = JOptionPane.showInputDialog(null,"Digite o texto que gostaria de descriptografar: ");
                 descriptografar(nome);    
              }
        }while(resp != 3);
        System.exit(0);
    }
}
