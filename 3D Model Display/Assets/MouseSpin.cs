using UnityEngine;

public class MouseSpin : MonoBehaviour {

    Vector3 mouseStart;
    Vector3 rotateVec;
    int slowdown;

    void Start()
    {
        mouseStart = Input.mousePosition;
        rotateVec = Vector3.zero;
        slowdown = 250;
    }

    // Update is called once per frame
    void Update () {
        if (Input.GetMouseButtonDown(0))
        {
            mouseStart = Input.mousePosition;
        }
        if (Input.GetMouseButton(0)) {
            rotateVec = ((mouseStart - Input.mousePosition) / Time.deltaTime)/slowdown;
            mouseStart = Input.mousePosition;
        }
        transform.Rotate(rotateVec, Space.World);
        rotateVec = rotateVec * (0.9f);
    } 
}
