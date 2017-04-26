/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pack.dao.daoToko;
import pack.dao.implementToko;
import pack.model.m_toko;
import pack.view.home;
import pack.model.tableModelToko;
/**
 *
 * @author Smktelkom
 */
public class controllerToko {
    home hm;
    implementToko impToko;
    List<m_toko> lt;
    
    public controllerToko(home hm){
        this.hm = hm;
        impToko = new daoToko();
        lt = impToko.getAll();
    }
    
//mengkosongkan isian field
    public void Reset(){
        hm.getkode().setText("");
        hm.getnama().setText("");
        hm.getharga().setText("");
        hm.getkategori().setSelectedItem(null);
        hm.getjenis().setSelectedItem(null);
    }
    
//menghapus data yang dipilih
    public void Hapus() {
        if (hm.getkode().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(hm, "Masukkan kode barang");
        } else {
            String kode = (hm.getkode().getText());
            impToko.HapusData(kode);
            JOptionPane.showMessageDialog(hm, "Data berhasil dihapus");
        }
    }  
    
//menyimpan data
    public void SimpanData(){
        m_toko toko = new m_toko();
        toko.setkode(hm.getkode().getText());
        toko.setnama(hm.getnama().getText());
        toko.setharga(hm.getharga().getText());
        toko.setkategori(hm.getkategori().getSelectedItem().toString());
        toko.setjenis(hm.getjenis().getSelectedItem().toString());
        impToko.SimpanData(toko);
    }

//mengubah data
    public void Ubah(){
        m_toko toko = new m_toko();
        toko.setkode(hm.getkode().getText());
        toko.setnama(hm.getnama().getText());
        toko.setkategori(hm.getkategori().getSelectedItem().toString());
        toko.setjenis(hm.getjenis().getSelectedItem().toString());
        toko.setharga(hm.getharga().getText());
        impToko.UbahData(toko);
    }

    public void isiTable() {
        lt =impToko.getAll();
        tableModelToko tmt = new tableModelToko(lt);
        hm.getTabel1().setModel(tmt);
    }

    public void isiField(int row){
        hm.getkode().setText(lt.get(row).getkode().toString());
        hm.getnama().setText(lt.get(row).getnama().toString());
        hm.getkategori().setSelectedItem(lt.get(row).getkategori().toString());
        hm.getjenis().setSelectedItem(lt.get(row).getjenis().toString());
        hm.getharga().setText(lt.get(row).getharga().toString());
    }

    public void CariKategori(){
        if (!hm.getcarikategori().getSelectedItem().toString().isEmpty()) {
            isiTableCariKategori();
        } else {
            JOptionPane.showMessageDialog(hm, "Silahkan Pilih Kategori");
        }
    }

    private void isiTableCariKategori() {
        String item = hm.getcarikategori().getSelectedItem().toString();
        lt = impToko.getCariKategori(item);
        tableModelToko tmt = new tableModelToko(lt);
        hm.getTabel1().setModel(tmt);
    }
}
