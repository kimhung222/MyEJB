/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;
import com.app.*;
import javax.naming.*;
import appclient.Students;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.ejb.EJB;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admin
 */
public class MainJFrame extends javax.swing.JFrame {

    @EJB
    private static StudentSessionBeanRemote studentSessionBean;
    public Integer chosen_id = null;
    
    
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        addListener();
    }
    

    

    public void addListener(){

        
    // GetDB
    List<Students> list_student = studentSessionBean.findAll();
    String[] cols = {"ID", "Name", "Student ID", "Class", "Point"};
    DefaultTableModel model = new DefaultTableModel(0,0);
    model.addColumn("ID");
    model.addColumn("Name");
    model.addColumn("Student ID");
    model.addColumn("Class");
    model.addColumn("Point");
    for(int i=0;i<list_student.size();i++){
        model.addRow(new Object[]{ list_student.get(i).getId(),list_student.get(i).getName(), list_student.get(i).getSid(), list_student.get(i).getClasss(), list_student.get(i).getPoint()});
    }
    stdTable.setModel(model);
    // Load Completed
 
    btn_add.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            Students new_s = new Students(Integer.parseInt(s_id.getText()),sname.getText(),Integer.parseInt(ssid.getText()),sclass.getText(),sfa.getText(),null,Float.parseFloat(spoint.getText()));
            //Integer id, String name, int sid, String classs, String faculty, Date lastUpdate, float point
            List<Students> list_student = studentSessionBean.add(new_s);
            //Render
            String[] cols = {"ID", "Name", "Student ID", "Class", "Point"};
            DefaultTableModel model = new DefaultTableModel(0,0);
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Student ID");
            model.addColumn("Class");
            model.addColumn("Point");
            for(int i=0;i<list_student.size();i++){
                model.addRow(new Object[]{ list_student.get(i).getId(),list_student.get(i).getName(), list_student.get(i).getSid(), list_student.get(i).getClasss(), list_student.get(i).getPoint()});
            }
            stdTable.setModel(model);
        //
        }
    });
    
    btn_edit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        Students new_s = new Students(Integer.parseInt(s_id.getText()),sname.getText(),Integer.parseInt(ssid.getText()),sclass.getText(),sfa.getText(),null,Float.parseFloat(spoint.getText()));
        // Test//
        //
        List<Students> list_student = studentSessionBean.edit(new_s);
            String[] cols = {"ID", "Name", "Student ID", "Class", "Point"};
            DefaultTableModel model = new DefaultTableModel(0,0);
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Student ID");
            model.addColumn("Class");
            model.addColumn("Point");
            for(int i=0;i<list_student.size();i++){
                model.addRow(new Object[]{ list_student.get(i).getId(),list_student.get(i).getName(), list_student.get(i).getSid(), list_student.get(i).getClasss(), list_student.get(i).getPoint()});
            }
            stdTable.setModel(model);
            
        }
    });
    btn_del.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            if(chosen_id==null){
                JOptionPane.showMessageDialog(new JFrame(),"You have to choose the row", "Dialog",JOptionPane.ERROR_MESSAGE);               
                return;
            }
            List<Students> list_student = studentSessionBean.delete(chosen_id);            
            String[] cols = {"ID", "Name", "Student ID", "Class", "Point"};
            DefaultTableModel model = new DefaultTableModel(0,0);
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Student ID");
            model.addColumn("Class");
            model.addColumn("Point");
            for(int i=0;i<list_student.size();i++){
                model.addRow(new Object[]{ list_student.get(i).getId(),list_student.get(i).getName(), list_student.get(i).getSid(), list_student.get(i).getClasss(), list_student.get(i).getPoint()});
            }
            stdTable.setModel(model);            
        }
    });

    
    
        
        //End GetDB
          
        // Table List Listener
        stdTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            Integer index_q = Integer.parseInt(stdTable.getValueAt(stdTable.getSelectedRow(), 0).toString());
            chosen_id = index_q;
            Students temp_student = list_student.get(index_q-1);
            s_id.setText(temp_student.getId().toString());
            sname.setText(temp_student.getName());
            ssid.setText(stdTable.getValueAt(stdTable.getSelectedRow(), 2).toString());
            sclass.setText(stdTable.getValueAt(stdTable.getSelectedRow(), 3).toString());
            spoint.setText(stdTable.getValueAt(stdTable.getSelectedRow(), 4).toString());
            semail.setText(temp_student.getEmail());
            simage.setText(temp_student.getImage());
            sfa.setText(temp_student.getFaculty());
        }
        
        
    });        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stdTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        s_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ssid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sclass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sfa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        spoint = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        semail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        simage = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Management");
        jLabel1.setToolTipText("");

        stdTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        stdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", "", null},
                {null, "", "", "", null},
                {null, "", "", "", null},
                {null, "", "", "", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Student ID", "Class", "Point"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stdTable.setToolTipText("");
        stdTable.setRowHeight(23);
        jScrollPane1.setViewportView(stdTable);

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Student ID");

        jLabel5.setText("Class");

        jLabel6.setText("Faculty");

        jLabel7.setText("Point");

        jLabel8.setText("Email");

        jLabel9.setText("Avatar");

        btn_add.setText("Thêm");

        btn_del.setText("Xóa");

        btn_edit.setText("Sửa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sname)
                            .addComponent(s_id)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(simage, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(semail)
                            .addComponent(spoint)
                            .addComponent(sfa)
                            .addComponent(sclass)
                            .addComponent(ssid))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ssid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(sclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(sfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(spoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(semail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(simage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_del, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            
              
                
                
                
                
                
                
                
                
                
                
                
                
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_edit;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField s_id;
    private javax.swing.JTextField sclass;
    private javax.swing.JTextField semail;
    private javax.swing.JTextField sfa;
    private javax.swing.JTextField simage;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField spoint;
    private javax.swing.JTextField ssid;
    private javax.swing.JTable stdTable;
    // End of variables declaration//GEN-END:variables

}
