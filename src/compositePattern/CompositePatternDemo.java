package compositePattern;

import java.awt.List;
import java.util.Enumeration;
import java.util.Vector;

/*组合模式：
 * 实际上和二叉树非常类似*/
public class CompositePatternDemo {
	public static void main(String agrs[]){
			TreeNode tree=new TreeNode("A");
			TreeNode treenodeB=new TreeNode("B");
			TreeNode treenodeC=new TreeNode("C");
			
			tree.add(treenodeB);
			treenodeB.add(treenodeC);
			bianLiTree(tree);
	}
	public static void bianLiTree(TreeNode node){
		Enumeration<TreeNode> e=node.getChildern();
		if (e.hasMoreElements()) {
			TreeNode treeNode = (TreeNode) e.nextElement();
			System.out.println(treeNode.getNameString());
			bianLiTree(treeNode);
	}else{
		return ;
	}
}
}
class TreeNode{
	private String nameString;
	private TreeNode parent;
	private Vector<TreeNode> childern=new Vector<TreeNode>();
	
	public TreeNode(String name){
		this.nameString=name;
	}
	public void add(TreeNode node){//添加孩子节点
		this.childern.add(node);
	}
	public void remove (TreeNode node){//删除孩子节点
		this.childern.remove(node);
	}
	public Enumeration<TreeNode> getChildern(){//取得孩子节点
		return childern.elements();
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}	
}