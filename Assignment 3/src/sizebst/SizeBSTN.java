package sizebst;

/**
 * Instances of class SizeBSTN are Nodes of the Size Binary Search Tree 
 * @author lou
 *
 */
public class SizeBSTN {
	SizeBSTN LSubtree;  // left subtree of this tree (may be null)
	SizeBSTN RSubtree;  // right subtree of this tree (may be null)
	int data; // data at this node of the tree
	int size; // number of tree entries that are less than or equal to data

/**
 * create a new leaf of the tree with the given data
 * @param data
 */
	public SizeBSTN(int data){
		LSubtree = null;
		RSubtree = null;
		this.data = data;
		size = 1;
	}
	
	/* see assignment for proper format for nodeString
	 */
	public static String nodeString(SizeBSTN node){
		if(node == null)
			return null;
		else{
			return "["+nodeString(node.LSubtree)+" "+node.data+","+node.size+" "+nodeString(node.RSubtree)+"]";
		}
		
	}
	
	/**
	 * search for the number target in the tree this node is the root of
	 * @param target number to search for
	 * @return either the node that holds target,
	 * if there is one, or the node which should point to the node that 
	 * will hold target if it is added now  
	 */
	public static SizeBSTN getNode(SizeBSTN node, int target){
		if(node==null){
			return null;
		}
		else{
			SizeBSTN ptr = node, prev = null;
			while(ptr!=null){
				if(ptr.data == target){
					return ptr;
				}
				else if(ptr.data > target){ //target is less than the data at the node shift rootNode to the left subtree.
					prev = ptr;
					ptr = ptr.LSubtree;
				}
				else{ // target is greater than the data in the node shift node to the right subtree.
					prev = ptr;
					ptr = ptr.RSubtree;
				}
			}
			return prev;
		}
	}
	/**
	 * like getNode but increments size fields as appropriate
	 * @param target number to search for
	 */
	public static void getNodeIncr(SizeBSTN node, int target){
		SizeBSTN ptr = node;
		
		
		// THE TARGET == PTR.DATA CASE SHOULD NOT BE IN THIS METHOD AS WE ARE ONLY ADJUSTING THE SIZES
		// IF THERE IS A NEW NODE BEING INSERTED INTO THE TREE
		
		
		while(ptr!=null){ //going through the tree
			//check if greater than or less than
			if(ptr.data > target){ // leaf data is greater than the target
				ptr.size++;
				ptr = ptr.LSubtree;
			}
			else{ // ptr.data < target | leaf data is less than the target
				ptr = ptr.RSubtree;
			}
		}
	}
	
	/**
	 * actually calculates number of numbers <= target.  
	 * Does search for target like getNode but adds up 
	 * the size fields of all nodes whose data is <= target.
	 * @return the number of nodes with data <= target in the
	 * tree this node is the root of.
	 */
	public static int sumNodesLeq(SizeBSTN node, int target){
		SizeBSTN ptr = node;
		int sum = 0;
		while(ptr!=null){ // going through the tree
			if(ptr.data==target){// target node is found, now we have to count all
				sum+=ptr.size; // adding the size of the target node to the total sum
				break;//breaks out of the loop because target was found
			}
			else if(ptr.data < target){
				sum+=ptr.size;
				ptr = ptr.RSubtree;
			}
			else{// ptr.data > target
				ptr = ptr.LSubtree;
			}
		}
		return sum;
	}	
}