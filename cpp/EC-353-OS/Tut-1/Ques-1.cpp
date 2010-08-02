#include<iostream>
#include <cstdlib>
#include<pthread.h>
#include<unistd.h>
using namespace std;

void *thread_function(void *arg){
	int i;
	for(i = 0; i < 20; i++){
		cout<<"in thread\n";
		sleep(1);
	}
	return NULL;
}

int main(void){
	pthread_t mythread;
	cout<<"Hello World";
	if(pthread_create(&mythread, NULL, thread_function, NULL)){
		cout<<"creating\n";
		exit(-1);
	}
	if(pthread_join(mythread, NULL)){
		cout<<"waiting\n";
		exit(-1);
	}
	exit(0);
}
