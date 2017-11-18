using UnityEngine;

public class TouchSpin : MonoBehaviour {
    Vector3 rotationAmount;
    float slowdown = 4; // factor by which to reduce rotation

    // Update is called once per frame
    void Update () {
        if(Input.touchCount == 1) {
            Touch finger = Input.GetTouch(0);
            if(finger.deltaPosition.magnitude > 0) {
                rotationAmount = -finger.deltaPosition;
            }
        }
        transform.Rotate(rotationAmount/slowdown, Space.World);
        rotationAmount *= 0.9f;
    }
}
