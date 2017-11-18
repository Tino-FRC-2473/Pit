using UnityEngine;

public class TouchTrigger : MonoBehaviour {
    float elapsedTime;
	// Update is called once per frame
	void Update () {
        if (Input.touchCount == 1) {
            Touch finger = Input.GetTouch(0);
            elapsedTime = 0f;
            if(finger.deltaPosition.magnitude == 0){
                elapsedTime += finger.deltaTime;
                if(elapsedTime > 1) {
                    Ray ray = Camera.main.ScreenPointToRay(finger.position);
                    RaycastHit hit;
                    if (Physics.Raycast(ray, out hit, Mathf.Infinity)) {
                        if (hit.transform.tag.Equals("Model")) {
                            Debug.Log("Hit " + hit);
                        }
                    }
                }
            }
        }
	}
}
