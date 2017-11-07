using UnityEngine;

public class Spin : MonoBehaviour {

	// Update is called once per frame
	void Update ()
    {
        if (Input.GetKey("a"))
        {
            transform.Rotate(Vector3.down, Space.World);
        }
        if (Input.GetKey("d"))
        {
            transform.Rotate(Vector3.up, Space.World);
        }
        if (Input.GetKey("s"))
        {
            transform.Rotate(Vector3.left, Space.World);
        }
        if (Input.GetKey("w"))
        {
            transform.Rotate(Vector3.right, Space.World);
        }
    }
}
