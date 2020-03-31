/*
Class Node for maintaining node with Integer element and previous and next node making Linked List Doubly
*/
class Node<T>(var element: T, var prev: Node<T>? = null, var next: Node<T>? = null)
/*
Class DoublyLinkedList with private members length, head and tail by default 0, null, null respectively
 */
class DoublyLinkedList <T> {
    var length = 0
    var head: Node<T>? = null
    var tail: Node<T>? = null
}
/*
Function to insert an element at the start of the Linked List
*/
fun <T> DoublyLinkedList<T>.insertFirst(value: T){
    val newNode: Node<T> = Node(value)
    val h= head
    newNode.next= head
    head= newNode
    if(h== null) tail= newNode else h.prev= newNode
    length++
}
/*
Function to insert an element at the end of the Linked List
*/
fun <T> DoublyLinkedList<T>.insertLast(value: T){
    val newNode: Node<T> = Node(value)
    val t= tail
    newNode.prev= tail
    tail= newNode
    if(t== null) head= newNode else t.next= newNode
    length++
}
/*
Function to delete the first element of the Linked List returning true if deletion successful and false otherwise
*/
fun <T> DoublyLinkedList<T>.deleteFirst():Boolean{
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
fun <T> DoublyLinkedList <T>.deleteLast():Boolean{
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
fun <T> DoublyLinkedList <T>.forwardTraverse(){
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
fun <T> DoublyLinkedList <T>.backwardTraverse(){
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
fun <T> DoublyLinkedList <T>.search(value: T):Boolean{
    var h= head
    while(h!= null){
        if(h.element== value)
            return true
        h= h.next
    }
    return false
}
/*
A Boolean Function with two Integer parameters value and target to insert the value after target node if target is found
in the Linked List and return true and return false otherwise
*/
fun <T> DoublyLinkedList <T>.insertAfter(value: T, target: T): Boolean{
    val newNode= Node(value)
    var h= head

    while (h!= null) {
        if (h?.element == target) {
            if(h==tail){
                tail= newNode
            }
            h.next?.prev = newNode
            newNode.prev = h
            newNode.next = h.next
            h.next = newNode
            length++
            return true
        }
        h = h?.next
    }
    return false
}
/*
A Boolean Function with two Integer parameters value and target to insert the value before target node if target is found
in the Linked List and return true and return false otherwise
*/
fun <T> DoublyLinkedList <T>.insertBefore(value: T, target: T): Boolean{
    val newNode: Node<T>? = Node(value)
    var h= head

    while (h!= null) {
        if (h?.element == target) {
            if(h==head){
                head=newNode
            }
            newNode?.prev = h.prev
            newNode?.next = h
            h.prev?.next = newNode
            h.prev = newNode
            length++
            return true
        }
        h = h?.next
    }
    return false
}