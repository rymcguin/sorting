//Ryan McGuiness
#include <iostream>
#include <vector>
#include <string>
#include "linked_list.h"
#include "hash_set.h"
HashSet::HashSet(int size){
   this->size = size;
   this->table = new LinkedList*[size];
	for (int i = 0; i < size; i++){
		this->table[i] = new LinkedList();
	}
}
HashSet::~HashSet(){
	for (int i = 0; i < size; i++){
		if (this->table[i] != NULL){
			delete this->table[i];
		}
	}
}
bool HashSet::contains(unsigned int key){
   int hash = this->hash(key);
   bool cont;
   if(table[hash]->find(key) == -1){
      cont = false;
   }
	return cont;
}

bool HashSet::insert(unsigned int key){
	int hash = this->hash(key);
	return table[hash]->insert_tail(key);
}

bool HashSet::remove(unsigned int key){
	int hash = this->hash(key);
	if (this->contains(key)){
		int index = this->table[hash]->find(key);
		this->table[hash]->remove_at_index(index);
		return true;
	}
	return false;
}
unsigned int hash_str(string str) {
    unsigned int b = 378551;
    unsigned int a = 63689;
    unsigned int hash = 0;
	 for(std::size_t i = 0; i < str.length(); i++) {
		hash = hash * a + str[i]; 
		a =a*b;
	 }
    return(hash & 0x7FFFFFFF);
}
unsigned int hash(unsigned int prehash){
	return prehash % size;
}
