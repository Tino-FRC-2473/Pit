using UnityEngine;

public class CameraZoom : MonoBehaviour {

    float slowdown = 4;
    float closestCamera = -3f;
    float farthestCamera = -10f;

	// Update is called once per frame
	void Update () {
		if(Input.touchCount == 2) {
            Touch touchOne = Input.GetTouch(0);
            Touch touchTwo = Input.GetTouch(1);

            Vector2 touchOnePrevious = touchOne.position - touchOne.deltaPosition;
            Vector2 touchTwoPrevious = touchTwo.position - touchTwo.deltaPosition;

            float previousDistance = (touchOnePrevious - touchTwoPrevious).magnitude;
            float currentDistance = (touchOne.position - touchTwo.position).magnitude;

            if(previousDistance < currentDistance && transform.position.z < closestCamera) {
                transform.Translate(Vector3.forward/slowdown);
            }
            else if (previousDistance > currentDistance && transform.position.z > farthestCamera) {
                transform.Translate(Vector3.back/slowdown);
            }
        }
	}
}
