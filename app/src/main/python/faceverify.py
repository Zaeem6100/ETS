
from deepface import DeepFace as df


def verify(img1,img2):
    return df.verify(img1_path = img1, img2_path = img2,enforce_detection=False)['verified']

