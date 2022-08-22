package com.mycompany.find_transport.veiws;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import com.mycompany.find_transport.Find_transport;
public class Userveiw extends Find_transport{
    Navigation nav=new Navigation();
    public void showUserDetails(Vector data) {
        clear();
        // System.out.println(data);
        
        System.out.print("\033[1;34m");
        System.out.format("%90s","--------------------------------\n");
        System.out.format("%90s","|           USER DETAILS       |\n");
        System.out.format("%90s","--------------------------------\n");
        System.out.print("\033[0m");
        System.out.format("%-17s%-17s%-17s%-17s%-17s\n\n",
                "Name", "NIC Number", "Phone Number", "Status","Rating");
        for (int i = 0; i < data.size(); i++) {
            String doc = (String) data.elementAt(i);
            String[] datalist = doc.split(",");
            for (int j = 0; j < datalist.length-1; j++) {
                System.out.format("%-17s", datalist[j]);
            }
            System.out.println();
            
        }
        if(data.size()==0){
            System.out.print("\033[1;31m");
            System.out.format("%90s","--------------------------------\n");
            System.out.format("%90s","|         User Not Found       |\n");
            System.out.format("%90s","--------------------------------\n");
            System.out.print("\033[0m");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        int navstate=nav.showNavigation(15);
    }
    
}
