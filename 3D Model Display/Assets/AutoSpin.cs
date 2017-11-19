using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AutoSpin : MonoBehaviour {
    public float spinSpeed;
    Vector3 rotateAmount;

    void Start() {
        rotateAmount.x = spinSpeed;
    }

    // Update is called once per frame
    void Update () {
        transform.Rotate(rotateAmount, Space.World);
	}
}
