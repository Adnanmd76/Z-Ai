import pyttsx3
import speech_recognition as sr
import datetime
import wikipedia
import webbrowser
import os

# Initialize text-to-speech engine
engine = pyttsx3.init()
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[0].id)  # Use default voice

def speak(audio):
    """Speaks the given text"""
    print(f"Z-Ai: {audio}")
    engine.say(audio)
    engine.runAndWait()

def wishMe():
    """Greets the user based on time"""
    hour = int(datetime.datetime.now().hour)
    if 0 <= hour < 12:
        speak("Good Morning!")
    elif 12 <= hour < 18:
        speak("Good Afternoon!")
    else:
        speak("Good Evening!")
    speak("I am Z-Ai. How may I help you?")

def takeCommand():
    """Takes voice input from user"""
    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("\nListening...")
        r.pause_threshold = 1
        r.adjust_for_ambient_noise(source)
        audio = r.listen(source)
    
    try:
        print("Recognizing...")
        query = r.recognize_google(audio, language='en-in')
        print(f"You said: {query}\n")
        return query.lower()
    except sr.UnknownValueError:
        print("Sorry, I didn't understand that.")
        return "none"
    except sr.RequestError:
        print("Network error. Please check your connection.")
        return "none"
    except Exception as e:
        print(f"Error: {e}")
        return "none"

def runAssistant():
    """Main assistant logic"""
    wishMe()
    
    while True:
        query = takeCommand()
        
        # Exit commands
        if 'exit' in query or 'quit' in query or 'bye' in query:
            speak("Goodbye! Have a great day.")
            break
        
        # Time query
        elif 'time' in query:
            strTime = datetime.datetime.now().strftime("%H:%M:%S")
            speak(f"The time is {strTime}")
        
        # Date query
        elif 'date' in query:
            strDate = datetime.datetime.now().strftime("%B %d, %Y")
            speak(f"Today's date is {strDate}")
        
        # Wikipedia search
        elif 'wikipedia' in query:
            try:
                speak("Searching Wikipedia...")
                query = query.replace("wikipedia", "").strip()
                results = wikipedia.summary(query, sentences=2)
                speak("According to Wikipedia")
                speak(results)
            except wikipedia.exceptions.PageError:
                speak("Sorry, I couldn't find that information.")
            except Exception as e:
                speak(f"An error occurred: {e}")
        
        # Open websites
        elif 'open youtube' in query:
            speak("Opening YouTube")
            webbrowser.open("https://youtube.com")
        
        elif 'open google' in query:
            speak("Opening Google")
            webbrowser.open("https://google.com")
        
        elif 'open github' in query:
            speak("Opening GitHub")
            webbrowser.open("https://github.com")
        
        # Play music
        elif 'play music' in query:
            music_dir = "C:\\Music"  # Change to your music directory
            if os.path.exists(music_dir):
                songs = os.listdir(music_dir)
                if songs:
                    os.startfile(os.path.join(music_dir, songs[0]))
                    speak("Playing music")
                else:
                    speak("No music files found in the directory")
            else:
                speak("Music directory not found")
        
        # General conversation
        elif 'how are you' in query:
            speak("I'm functioning well, thank you for asking!")
        
        elif 'your name' in query:
            speak("I am Z-Ai, your voice assistant")
        
        elif 'who created you' in query:
            speak("I was created by Adnan")
        
        # Default response
        else:
            speak("I can help you with time, date, Wikipedia searches, opening websites, or playing music. Just ask!")

if __name__ == "__main__":
    runAssistant()
