
public class MaxHeap
{
    private Packet[] heap;
    private int size;
    private int maxSize;
    private static final int FRONT=1;
 
    /*
     * CONSTRUCTORES
    */
    public MaxHeap()
    {
    	this(10);
    }
    
    public MaxHeap(int maxSize)
    {
        this.maxSize=maxSize;
        this.size=0;
        this.heap=new Packet[this.maxSize+1];
        this.heap[0].set=Integer.MAX_VALUE;
    }
 
    /*
     * INSERTAR 
    */
    public void insert(int element)
    {
    	this.heap[++this.size]=element;
        int current=this.size;
 
        while(this.heap[current]>this.heap[parent(current)])
        {
            swap(current,parent(current));
            current=parent(current);
        }	
    }
 
    /*
     * ELIMINAR
    */
    public int remove()
    {
        int popped=this.heap[FRONT];
        this.heap[FRONT]=this.heap[size--]; 
        this.maxHeapify(FRONT);
        return popped;
    }
    
    /*
     * IMPRIMIR
    */
    public void print()
    {
        for (int i=1; i<=this.size/2; i++ )
        {
            System.out.println(" PARENT : " + this.heap[i] + " LEFT CHILD : " + this.heap[2*i] + " RIGHT CHILD :" + this.heap[2*i+1]);
        }
    }
 
    /*
     * CONVERTIR ARBOL EN MAXHEAP
    */
    public void maxHeap()
    {
        for (int pos=(this.size/2); pos>=1; pos--)
        {
        	this.maxHeapify(pos);
        }
    }
 
 
    /*
     * METODOS PRIVADOS
    */
    private int parent(int pos)
    {
        return pos/2;
    }
 
    private int leftChild(int pos)
    {
        return (2*pos);
    }
 
    private int rightChild(int pos)
    {
        return (2*pos)+1;
    }
 
    private boolean isLeaf(int pos)
    {
        if (pos>=(this.size/2)  &&  pos<=this.size)
        {
            return true;
        }
        return false;
    }
 
    private void swap(int fpos,int spos)
    {
        int tmp;
        tmp=this.heap[fpos];
        this.heap[fpos]=this.heap[spos];
        this.heap[spos]=tmp;
    }
 
    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if (this.heap[pos]<heap[leftChild(pos)]  || this.heap[pos]<this.heap[rightChild(pos)])
            {
                if (this.heap[leftChild(pos)]>this.heap[rightChild(pos)])
                {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else
                {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }
    
    /*
     * MAIN
    */
    public static void main(String[] arg)
    {
        System.out.println("The Max heap is ");
        MaxHeap maxHeap=new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();
 
        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
    }
}