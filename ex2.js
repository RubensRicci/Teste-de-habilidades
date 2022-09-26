const readline = require('readline')
const fs = require('fs')
const readable = fs.createReadStream('list.txt')
var count = 0;
var matriz = []
var j=0

const rl = readline.createInterface({
    input: readable,
    output: process.stdout
})
rl.on('line', (line) => {
    espaco = line.indexOf(" ");
    matriz[j] = line.substr(0, espaco) + '.';
    matriz[j] += line.substr(espaco + 1);
    matriz[j] += "@matchit.com.br;";
    matriz[j] = matriz[j].toLowerCase();
    matriz[j] += geraSenha();
    console.log(matriz[j]);
    j++
})

function geraSenha() {
    var letraAleatoria = '';
    var numAleatorio = '';
    var caracteres = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    for (var i = 0; i < 4; i++) {
        letraAleatoria += caracteres.charAt(Math.floor(Math.random() * caracteres.length));
        numAleatorio += Math.floor(Math.random() * 10);
    }
    var senha = letraAleatoria + numAleatorio
    return senha;
}

