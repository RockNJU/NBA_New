
		package UI.common;

		import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;

		import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



		public class CreateTableforhot extends JPanel implements TableModelListener {
			public static void main(String[] args) {}

			private static final long serialVersionUID = 1L;
			JScrollPane roll;
			JTable table;
			String[] headTitle;
			Object data[][];
			Font fbig;
			Font fsmall;
			int picwidth;
			int piclength;
			int columnnum;
			
			// 允许出现图片的model
			class MyTableModel extends AbstractTableModel {
				// 单元格元素类型
				private Class[] cellType = { Icon.class, String.class, String.class };
				// 表头
				private String title[] = headTitle;

				// 模拟数据

				// 封装好的调控图片大小方法
				public ImageIcon getImageIcon(String path, int width, int height) {
					if (width == 0 || height == 0) {
						return new ImageIcon(this.getClass().getResource(path));
					}
					ImageIcon icon = new ImageIcon(path);
					icon.setImage(icon.getImage().getScaledInstance(width, height,
							Image.SCALE_DEFAULT));
					return icon;
				}
				
				//更新表格数据
				public Object[][] updatedata(Object[][] info,int columnnum){
					Object Data[][] = new Object[info.length][columnnum];
					for(int i = 0; i<info.length;i++){
						Object[] temp = new Object[columnnum+1];
						temp[0] = getImageIcon((String)info[i][0],
								picwidth, piclength);
						int tempadd = 1;
						while(columnnum!=0){
							temp[tempadd] = info[i][tempadd];
							columnnum--;
							tempadd++;
						}
						Data[i]= temp;
					}
					data = Data;
					return Data;
				}
				
				//初始化数据
				private Object data[][] = updatedata(CreateTableforhot.this.data,columnnum);

				public MyTableModel() {
				}

				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getColumnClass(int arg0) {
					// TODO Auto-generated method stub
					return cellType[arg0];
				}

				@Override
				public String getColumnName(int arg0) {
					// TODO Auto-generated method stub
					return title[arg0];
				}

				@Override
				public int getColumnCount() {
					// TODO Auto-generated method stub
					return title.length;
				}

				@Override
				public int getRowCount() {
					// TODO Auto-generated method stub
					return data.length;
				}

				@Override
				public Object getValueAt(int r, int c) {
					// TODO Auto-generated method stub
					if(data.length>=r)
						return data[r][c];
					else
						return null;
			
				}

				// 重写isCellEditable方法
				public boolean isCellEditable(int r, int c) {
					return false;
				}

				// 重写setValueAt方法
				public void setValueAt(Object value, int r, int c) {
					data[r][c] = value;
					this.fireTableCellUpdated(r, c);
				}
			}

			//建立表格
			public CreateTableforhot(String title[], Icon a, Icon b, Icon c, final Object data[][],
					int x, int y, int width, int height, int rowHeight, int rowwidth1,int columnnum,
					Font fbig, Font fsmall,final int picwidth, final int piclength) {
				/* 这本身是一个Panel,panel 是可以直接用的，传进信息便可以了直接使用 */
				/* title 是表头信息，data 是传进来的数据，二维字符串数组,x,y 是表格的坐标，wideth,height 是大小的设置,columnnum为要输出多少列 */
				// this.setLayout(null);
				this.setBounds(x, y, width, height);
				this.data = data;
				this.headTitle = title;
				this.piclength = piclength;
				this.picwidth = picwidth;
				this.fbig = fbig;
				this.fsmall = fsmall;

				
				MyTableModel model = new MyTableModel();
				table = new JTable(model);
				table.setRowHeight(rowHeight);
				RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);  
				table.setRowSorter(sorter);  
				// 为所有表格设上文字属性
				changefont();
				table.getTableHeader().setFont(fbig);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFillsViewportHeight(true);
				// table.setEnabled(false);
				// table.isEditing();
				table.getColumnModel().getColumn(0).setPreferredWidth(rowwidth1);
				// 各种颜色设定
				table.setBorder(new LineBorder(new Color(67, 54, 49), 2, true));
				table.setForeground(Color.DARK_GRAY);
				table.setBackground(new Color(252, 213, 146));
				table.setSelectionBackground(new Color(67, 54, 49));
				table.setSelectionForeground(Color.WHITE);
				table.setShowVerticalLines(false);// 是否显示垂直网格线?
				table.setGridColor(new Color(67, 54, 49));
				
				

				// 其他一些属性
				table.setDragEnabled(false); // 不许乱拖动
				table.getSelectionModel().setSelectionMode(
						ListSelectionModel.SINGLE_SELECTION); // 只允许单选
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);
				
				 //获得表头
					JTableHeader tableH = table.getTableHeader();
				    //设置表头的背景色
				    tableH.setBackground(new Color(252, 213, 146));
				    //设置表头的文字颜色
				    tableH.setForeground(new Color(255, 255, 255));
			}

			// 让第二行和第三行的字体不同,不同行颜色不同
			private void changefont() {
				TableColumnModel tcm = table.getColumnModel();
				TableColumn tc = tcm.getColumn(1);
				tc.setCellRenderer(new RowRenderer1());
				tcm.getColumn(2).setCellRenderer(new RowRenderer2());
				// TODO 自动生成的方法存根
			}

			// 第2/3竖行
			class RowRenderer1 extends DefaultTableCellRenderer {
				public Component getTableCellRendererComponent(JTable t, Object value,
						boolean isSelected, boolean hasFocus, int row, int column) {
					// 设置奇偶行的背景色，可在此根据需要进行修改
					table.setFont(fbig);
					if (row % 2 == 1)
						setBackground(new Color(246, 164, 21));
					else
						setBackground(new Color(231, 153, 16));

					return super.getTableCellRendererComponent(t, value, isSelected,
							hasFocus, row, column);
				}
			}

			class RowRenderer2 extends DefaultTableCellRenderer {
				public Component getTableCellRendererComponent(JTable t, Object value,
						boolean isSelected, boolean hasFocus, int row, int column) {
					// 设置奇偶行的背景色，可在此根据需要进行修改
					table.setFont(fsmall);
					if (row % 2 == 1)
						setBackground(new Color(246, 164, 21));
					else
						setBackground(new Color(231, 153, 16));

					return super.getTableCellRendererComponent(t, value, isSelected,
							hasFocus, row, column);
				}
			}

			// stop
			
			/* 用于刷新表格，info[][]为改动过后的数组，存储表格数据 */
			public void updateTable(Object info[][],int columnnum,String[] HeadTitle) {
				data = info;
				headTitle = HeadTitle;
				//MyTableModel model = new MyTableModel();
				MyTableModel model = (MyTableModel)table.getModel();
				model.updatedata(info,columnnum);
			}

			public void updateTable(String info[][], int rowheight, int rowwidth1,
					int rowwidth2, int rowwidth3) {
				/* 用于刷新表格，info[][]为改动过后的数组，存储表格数据 */

				data = info;
				DefaultTableModel model = new DefaultTableModel(data, headTitle);

				table.setModel(model);
				table.setRowHeight(rowheight);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFillsViewportHeight(true);
				table.setColumnSelectionAllowed(true);

				table.getColumnModel().getColumn(0).setPreferredWidth(rowwidth1);
				table.getColumnModel().getColumn(1).setPreferredWidth(rowwidth2);
				table.getColumnModel().getColumn(2).setPreferredWidth(rowwidth3);

				table.setVisible(true);
				table.repaint();
				this.repaint();
			}

			public JTable getTable() {
				return table;
			}

			public int getSelectedColumn() {
				return table.getColumnCount();
			}

			public int getSelectedRow() {
				return table.getSelectedRow();
			}

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				row = e.getFirstRow();

				System.out.println("----row----" + row);
				column = e.getColumn();
			}

			int row;
			int column;
			//得到选中单元格的数据
			public String getValueAt(int selectedRow, int i) {
				return 	table.getValueAt(selectedRow, i).toString();
			}

		}



