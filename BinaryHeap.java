// Min Heap
// Priority Queue
public class BinaryHeap {
	
	int capacity;
	int size;
	int heap[];
	
	BinaryHeap(int capacity){
		this.capacity=capacity;
		this.heap= new int[capacity];
		this.size=0;
	}
	
	public int GetParent(int child) {
		return (child)/2;
	}
	
	public int GetLeft(int parent) {
		return (2*parent);
	}
	
	public int GetRight(int parent) {
		return (2*parent)+1;
	}
	
	public boolean isFull() {
		return size==capacity;
	}
	public boolean isValid(int index) {
		return index>=1 && index<=size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void Swap(int child, int parent) {
		int temp=heap[child];
		heap[child]=heap[parent];
		heap[parent]=temp;
	}
	
	public void ShiftUp(int child) {
		int parent=GetParent(child);
		
		while(isValid(child) && heap[parent]>heap[child]) {
			Swap(child,parent);
			child=parent;
			parent=GetParent(child);
			
		}
	}
	public void Insert(int value) {
		if(isFull()) {
			System.out.println("heap is full");
			return;
		}
		size=size+1;
		heap[size]=value;
		ShiftUp(size);
	}
	
	private void ShiftDown(int index) {
		int left=GetLeft(index);
		int right=GetRight(index);
		
		int Minindex=index;
		
		if(isValid(left) && heap[Minindex]>heap[left]) {
			Minindex=left;
		}
		if(isValid(right) && heap[Minindex]>heap[right]) {
			Minindex=right;
		}
		
		if(Minindex!=index) {
			Swap(Minindex,index);
			ShiftDown(Minindex);
		}
		
	}
	
	public int GetMin() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return heap[1];
	}
	
	
	
	
	
	public int remove() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		
		int result=heap[size];
		if(!isEmpty()) {
			heap[1]=result;
			size--;
		}
		ShiftDown(1);
		return result;
	}
	
	public void PrintHeap() {
		for(int i=1; i<=size; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println(); 
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		
		BinaryHeap heap = new BinaryHeap(12);
		heap.Insert(55);
		heap.Insert(66);
		heap.Insert(77);
		heap.Insert(88);
		heap.Insert(99);
		heap.Insert(13);
		
		heap.PrintHeap();
		
		System.out.println(heap.GetMin());
		
		heap.PrintHeap();
		heap.remove();
		heap.PrintHeap();
		
		
		
		
		
		
		
	}

}
