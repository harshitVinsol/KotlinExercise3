/*
Class DoublyLinkedList with private members length, head and tail by default 0, null, null respectively
 */
class DoublyLinkedList{
    private var length= 0
    private var head: Node?= null
    private var tail: Node?= null
    /*
    Inner class Node for maintaining node with Integer element and previous and next node making Linked List Doubly
     */
    inner class Node(var element: Int, var prev: Node?= null, var next: Node?= null)
    /*
    Function to insert an element at the start of the Linked List
     */
    fun insertFirst(value: Int){
        val newNode= Node(value)
        val h= head
        newNode.next=head
        head= newNode
        if(h== null) tail= newNode else h.prev= newNode
        length++
    }
    /*
    Function to insert an element at the end of the Linked List
     */
    fun insertLast(value: Int){
        val newNode= Node(value)
        val t= tail
        newNode.prev= tail
        tail= newNode
        if(t== null) head= newNode else t.next= newNode
        length++
    }
    /*
    Function to delete the first element of the Linked List returning true if deletion successful and false otherwise
     */
    fun deleteFirst():Boolean{
        if(length== 0)
            return false
        else {
            head = head?.next
            head?.prev=null
            length--
            return true
        }
    }
    /*
    Function to delete the last element of the Linked List returning true if deletion successful and false otherwise
     */
    fun deleteLast():Boolean{
        if(length== 0)
            return false
        else{
            tail= tail?.prev
            tail?.next= null
            length--
            return true
        }
    }
    /*
    Function to print the list from head to tail
     */
    fun forwardTraverse(){
        var h= head
        print("\nDLL in forward: ")
        while(h?.next!= null){
            print("${h.element} ")
            h=h.next
        }
        print(h?.element)
    }
    /*
    Function to print list from tail to head
     */
    fun backwardTraverse(){
        var t= tail
        print("\nDLL in backward: ")
        while(t?.prev!= null){
            print("${t.element} ")
            t=t.prev
        }
        print(t?.element)
    }
    /*
    A Boolean function with an Integer parameter returning true if present in the Linked List and false otherwise
     */
    fun search(value: Int):Boolean{
        var h= head
        while(h?.next!= null){
            if(h.element== value || h.next?.element== value)
                return true
            h= h?.next
        }
        return false
    }
    /*
    A Boolean Function with two Integer parameters value and target to insert the value after target node if target is found
    in the Linked List and return true and return false otherwise
     */
    fun insertAfter(value: Int, target: Int): Boolean{
        val newNode= Node(value)
        if(head?.element == target){
            newNode.next= head?.next
            newNode.prev= head
            head?.next= newNode
            length++
            return true
        }
        else if(tail?.element == target){
            newNode.prev= tail
            newNode.next= null
            tail?.next=newNode
            tail= newNode
            length++
            return true
        }
        else{
            var h= head?.next
            while(h?.next!=tail){
                if(h?.element == target){
                    h.next?.prev= newNode
                    newNode.prev= h
                    newNode.next= h.next
                    h.next= newNode
                    length++
                    return true
                }
                h=h?.next
            }
        }
        return false
    }
    /*
    A Boolean Function with two Integer parameters value and target to insert the value before target node if target is found
    in the Linked List and return true and return false otherwise
     */
    fun insertBefore(value: Int, target: Int): Boolean{
        val newNode= Node(value)
        if(head?.element == target){
            newNode.next= head
            head?.prev= newNode
            head= newNode
            length++
            return true
        }
        else if(tail?.element == target){
            tail?.prev?.next= newNode
            newNode.prev= tail?.prev
            newNode.next= tail
            tail?.prev=newNode
            length++
            return true
        }
        else{
            var h= head?.next
            while(h?.next!=tail){
                if(h?.element == target){
                    newNode.prev= h.prev
                    newNode.next= h
                    h.prev?.next= newNode
                    h.prev= newNode
                    length++
                    return true
                }
                h=h?.next
            }
        }
        return false
    }
}