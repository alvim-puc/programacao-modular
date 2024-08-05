#include <iostream>

using namespace std;

class RevisaoAed {public:

    int fibLoop(int n){
        int a = 0, b = 1, c = a + b;

        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return c;
    }

    int fibRec(int n, int a, int b, int c, int index){
        if(n == index) return c;

        c = a + b;
        a = b;
        b = c;

        index++;

        return fibRec(n, a, b, c, index);
    }
    
};

class Imc {
private:
    float peso;
    float altura;

public:

    Imc(float p, float a) : peso(p), altura(a) {}

    void setPeso(float p){
        peso = p;
    }

    void setAltura(float a){
        altura = a;
    }

    float getPeso(){
        return peso;
    }

    float getAltura(){
        return altura;
    }

    float getImc(){
        return peso / (altura * altura);
    }

};

int main(){

    RevisaoAed revisaoaeds;

    int n;

    cin >> n;

    cout << revisaoaeds.fibLoop(n) << endl;
    cout << revisaoaeds.fibRec(n, 0, 1, 0, 0) << endl;

    float peso, altura;

    cin >> peso >> altura;

    Imc imc(peso, altura);

    cout << imc.getImc() << endl;

    return EXIT_SUCCESS;
}