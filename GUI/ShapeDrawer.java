import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeDrawer extends JFrame{
    private String selectedShape = "";

    public ShapeDrawer(){
        setTitle("Draw Shapes that you like");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3,1));

        JButton sqButton = new JButton("Square");
        JButton trButton = new JButton("Triangle");
        JButton reButton = new JButton("Rectangle");

        menuPanel.add(sqButton);
        menuPanel.add(trButton);
        menuPanel.add(reButton);

        DrawingPanel dp = new DrawingPanel();

        sqButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectedShape="Square";
                dp.repaint();
            }
        });

        trButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectedShape="Triangle";
                dp.repaint();
            }
        });

        reButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectedShape="Rectangle";
                dp.repaint();            
                }
        });

        add(menuPanel, BorderLayout.WEST);
        add(dp,BorderLayout.CENTER);
    }
        private class DrawingPanel extends JPanel{
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                int width = 100, height = 100;
                int x = (getWidth() - width)/ 2;
                int y = (getHeight() - height)/2 ;

                switch(selectedShape){
                    case "Square":
                        g.drawRect(x,y,width,height);
                        break;
                    case "Triangle":
                        int[] xPoints = {x + width/2, x, x + width};
                        int[] yPoints = {y, y + height, y + height};
                        g.drawPolygon(xPoints,yPoints,3);
                        break;
                    case "Rectangle":
                        g.drawRect(x,y,width, height*2);
                        break;
                }
            }
        }


        
    

    public static void main(String [] args){
        ShapeDrawer shapeDrawer = new ShapeDrawer();
        shapeDrawer.setVisible(true);
    }
}