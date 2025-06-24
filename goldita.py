import tkinter as tk
from tkinter import simpledialog
from PIL import Image, ImageTk
import pygame

RUTA_IMAGEN = r"C:\Users\ricoy\Downloads\kisspng-anti-obesity-medication-weight-loss-perfect-postpa-no-fat-chicks-5b272a7410d5b6.676288441529293428069.jpg"#modificar por tu imagen
RUTA_MUSICA = r"C:\Users\ricoy\Music\OYE GELDA 😈(MP3_160K).mp3"#modificar por tu audio

def mostrar_imagen_rotando():
    root_img = tk.Toplevel()
    root_img.title("Imagen rotando")
    img = Image.open(RUTA_IMAGEN)
    tk_img = ImageTk.PhotoImage(img)
    label = tk.Label(root_img, image=tk_img)
    label.pack()
    angle = 0

    def rotar():
        nonlocal angle, img, tk_img
        angle = (angle + 10) % 360
        img_rotada = img.rotate(angle)
        tk_img = ImageTk.PhotoImage(img_rotada)
        label.config(image=tk_img)
        label.image = tk_img
        root_img.after(100, rotar)

    rotar()

root = tk.Tk()
root.withdraw()

peso = simpledialog.askfloat("Peso", "Ingresa tu peso en kg:")

if peso is not None:
    if peso > 70:
        mostrar_imagen_rotando()
        pygame.init()
        pygame.mixer.init()
        pygame.mixer.music.load(RUTA_MUSICA)
        pygame.mixer.music.play()
        print("Peso alto detectado")

        while pygame.mixer.music.get_busy():
            root.update()
    else:
        tk.messagebox.showinfo("Peso", "Peso dentro del rango")
else:
    tk.messagebox.showinfo("Peso", "No ingresaste ningún valor")