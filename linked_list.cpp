//Ryan McGuiness
#include <iostream>
#include <vector>
#include <string>
#include "linked_list.h"
using namespace std;
Node::Node(){
	this->data = 0;
	this->next = NULL;
}
Node::Node(unsigned int data){
	this.data = data;
}
LinkedList::LinkedList(){
    this.length = 0;
    this->head = NULL;
	this->tail = NULL;
}

LinkedList::~LinkedList(){
    if (head != NULL)
	{
		delete head;
		cout<<"List deleted."
	}
}

bool LinkedList::insert_tail(unsigned int data){
	Node* node = new Node(data);
    node->next = this->tail;
    this->tail = node;
    this->length++;
	return true;
}

bool LinkedList::insert_head(unsigned int data){
	Node* node = new Node(data);
    node->next = this->head;
    this->head = node;
    this.length++;
	return true;
}

bool LinkedList::insert_at_index(unsigned int index, unsigned int data){
	Node* temp1 = new Node(data);
	temp1->next = NULL;
	if(index < 0){
		return false;
	}else if(index == 1){
		temp1->next = head;
		head = temp1;
		return true;
	}else{
	Node* temp2 = head;
    for(int i = 0; i < index - 2; i++){
		temp2 = temp2->next;
	}
	temp1->next = temp2->index
	temp2->next = temp1;
	this.length++;
	return true;
	}
}

bool LinkedList::remove_tail(){
	if (length == 0) {
       return false;
    }
    else if (length == 1) {
    	Node* temp = new Node();
		temp = head;
    	this->head = tail 
		tail = null;
    	this.length = 0;
    	return true;
    }else {
		Node* current = head;
		for (int i = 0; i < size - 2; i++) {
			current = current.next;
    	}
      	Node* temp = new Node();
	  	temp = tail;
      	tail = current;
      	tail->next = NULL;
      	size--;
      	return true;
    }
}

bool LinkedList::remove_at_index(unsigned int index){
		if (index < 0 || index >= this.length) {
    		return false;
    	} else {
			Node* previous = new Node();
			previous = head;
      		for (int i = 1; i < index; i++) {
        		previous = previous.next;
      		}
      		Node* current = new Node();
			current = previous->next;
      		previous.next = current.next;
      		length--;
      		return true;
    }
}

unsigned int LinkedList::find(unsigned int data){
	Node* node = new Node();
	node = head;
	for(int i = 0; i < length - 2; i++){
		if(node->data == data){
			return i;
		}else{
			node = node->next;
		}
	}
	return -1;
}
unsigned int LinkedList::length(){
	return this.length;
}
