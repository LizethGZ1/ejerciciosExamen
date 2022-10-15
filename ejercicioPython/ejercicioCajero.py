from datetime import datetime
from tokenize import Double

nip = 1235
saldo1 = 1000
saldo = 1000
flag=True
acum =0
cont = 0    
num = []
sal = []
fecha = []

  


print('--------- Bienvenido al cajero automático de Minsait ---------')

#Limita el número de inicios de sesión
for i in range(3):
  numero = float(input('Por favor ingrese su contraseña:'))
    #verificar cuenta y contraseña
  if numero == nip :
    flag = True
    break
  elif i <= 1 :
    rest = 2-i
    print('Lo siento, la contraseña es incorrecta, aún tienes ',rest,' Intentos')
  else :
    print('Lo siento, por seguridad se ha bloqueado tu tarjeta')
    break
  flag= False
#Seleccione la función después de un inicio de sesión exitoso

if flag: 
  answer = 's'
  while answer == 's':
    ope = int(input('Bienvenid@, Lizeth Gonzalez Zaragoza \n Selecciona una opción: \n 1. Consultar Saldo \n 2. Retirar saldo \n 3. Histórico de movimiento \n 4.Salir\n'))
    if ope == 1:
      print('__________________________________________________________________________________________')
      print(' ---> CONSULTAR SALDO')
      print('Tu saldo actual es de: ',saldo)
      print('__________________________________________________________________________________________')

    elif ope == 2:
      print('__________________________________________________________________________________________')
      print(' ---> RETIRAR EFECTIVO')
      retirar = float(input('Ingresa la cantidad a retirar: '))
      if retirar <= 0:
        print('Estas ingresando números negativos')
      elif saldo >= retirar:
        saldo = saldo - retirar
        acum=acum+retirar
        cont=cont+1
        num.append(retirar)
        sal.append(saldo)
        fecha.append(datetime.now())
        print('DINERO RETIRADO EXITOSAMENTE')
        print('__________________________________________________________________________________________')
      else:
        print('FONDOS INSUFICIENTES')
        print('__________________________________________________________________________________________')
      print("")

    elif ope == 3:
      print('__________________________________________________________________________________________')
      print(' ---> MOVIMIENTOS HISTÓRICOS')
      if acum==0:
        print('Saldo actual: ',saldo1)
        print('Sin movimientos recientes')
        print('__________________________________________________________________________________________')
      else:
        print('Saldo anterior: ',saldo1)
        for j in range(cont):
          print('Fecha de retiro: ',fecha[j],' La cantidad de: ',num[j])
          print('Saldo actual: ',sal[j])
          print('__________________________________________________________________________________________')
      
    elif ope == 4:
      print('__________________________________________________________________________________________')
      print('GRACIAS POR USAR EL CAJERO AUTOMATICO')
      print('__________________________________________________________________________________________')
      exit()
    else:
      print('Ha ocurrido un error, elige una opcion valida')
      
  
    answer = input('¿Continuar? s/n \n')



