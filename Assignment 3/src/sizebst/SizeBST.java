package sizebst;


/**
 * Class SizeBST represents a Binary Search Tree that can also be used, for any integer j,
 *  to answer the question "how many numbers in the tree are less than or equal to j" in worst 
 *  case time h where h is the height of the tree (not the number of nodes).
 * 
 *  The actual nodes of the tree are of class SizeBSTN.  SizeBST represents the overall tree.
 *  IF instance variable rootNode is null, the tree is empty, otherwise rootNode is the root
 *  of the tree of SizeBSTN's
 * @author lou
 *
 */
public class SizeBST {
	SizeBSTN rootNode;

	public SizeBST(SizeBSTN root){
		rootNode =  root;
	}

	public String toString(){
		if (rootNode == null)
			return "(null)";
		else {
			return "("+ SizeBSTN.nodeString(rootNode) + ")";
		}
	}

	/**
	 * @param target the number to search for
	 * @return true iff target is in this tree
	 */
	public boolean search(int target){
		SizeBSTN ptr = rootNode;
		if(ptr==null){
			return false;
		}
		else{
			while(ptr!=null){
				if(target==ptr.data)
					return true;// the target is found
				else if(target < ptr.data){// if the target is less than the data found in the node
						ptr = ptr.LSubtree; //change the rootNode to the left child of the rootNode
					}
				else{ // if the target is greater than the data in the node
					ptr = ptr.RSubtree;					
				}
			}
			return false;
		}
	}

	/**
	 * insert newData into tree;  if already there, do not change tree
	 * @param newData int to insert
	 */
	public void insert(int newData){
		// fill in here
		SizeBSTN newNode = new SizeBSTN(newData);
		if(rootNode==null){// if the tree is empty, the newData will become the root
			rootNode = newNode;
		}
		else{
			SizeBSTN temp;
			temp = SizeBSTN.getNode(rootNode, newData);
			if(temp.data > newData){
				SizeBSTN.getNodeIncr(rootNode,newData);
				temp.LSubtree = newNode;
			}
			else{
				SizeBSTN.getNodeIncr(rootNode, newData);
				temp.RSubtree = newNode;
			}
		}
		
	}

	/**
	 * @return returns how many numbers in the tree are less than or equal to target.  Returns -1 if tree is empty
	 * @param target
	 */
	public int numLEq(int target){
		if(rootNode==null)
			return -1;
		else{
			return SizeBSTN.sumNodesLeq(rootNode, target);
		}
		
		
	}

	public static void main(String args []){
		SizeBST testTree = new SizeBST(null);
		testTree.insert(40);
		testTree.insert(20);
		testTree.insert(60);
		System.out.println(testTree.toString());
		testTree.insert(10);
		testTree.insert(50);
		testTree.insert(30);
		testTree.insert(55);
		testTree.insert(53);
		System.out.println(testTree.toString());
		System.out.println(testTree.numLEq(40));
		// add any test code you want here - this is not graded.  Just be sure it compiles
	}
}
