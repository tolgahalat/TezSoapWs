/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tolga.tezsoapws.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import tolga.tezsoapws.entity.Adres;
import tolga.tezsoapws.entity.Mukellef;

/**
 *
 * @author Tolga
 */
public class TezUtil {

    public static Mukellef getById(String id) {
        Mukellef mukellef = new Mukellef();
        Adres adres = new Adres();
        
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from public.\"TezMukellef\" where \"Id\" = " + id);
            while (rs.next()) {
                mukellef.setId(rs.getInt("Id"));
                mukellef.setAd(rs.getString("Ad"));
                mukellef.setSoyad(rs.getString("Soyad"));
                mukellef.setTckn(rs.getString("Tckn"));
                mukellef.setVkn(rs.getString("Vkn"));
                mukellef.setVdKodu(rs.getString("VdKodu"));
                mukellef.setDogumYeri(rs.getString("DogumYeri"));
                mukellef.setIsYeriTuru(rs.getString("IsYeriTuru"));
                mukellef.setBabaAdi(rs.getString("BabaAdi"));
                mukellef.setAnneAdi(rs.getString("AnneAdi"));
                mukellef.setIseBaslamaTarihi(rs.getString("IseBaslamaTarihi"));
                mukellef.setIsiBirakmaTarihi(rs.getString("IsıBirakmaTarihi"));
                mukellef.setDogumTarihi(rs.getString("DogumTarihi"));
                mukellef.setUnvan(rs.getString("Unvan"));
                mukellef.setVdAdi(rs.getString("VdAdi"));
                
                adres.setIl(rs.getString("AdresIl"));
                adres.setIlce(rs.getString("AdresIlce"));
                adres.setMahalle(rs.getString("AdresMah"));
                adres.setCaddeSokak(rs.getString("AdresCaddeSokak"));
                
                mukellef.setAdres(adres);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return mukellef;
    }
}
